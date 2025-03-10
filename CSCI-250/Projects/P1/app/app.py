from flask import Flask, request, render_template
import pickle
import pandas as pd
import numpy as np

app = Flask(__name__)

with open('xgb_model.pkl', 'rb') as f:
    model = pickle.load(f)

with open('scaler.pkl', 'rb') as f:
    scaler = pickle.load(f)

default_means = {
    'Tenure': 9.00,
    'CityTier': 1.00,
    'WarehouseToHome': 14.00,
    'HourSpendOnApp': 3.00,
    'NumberOfDeviceRegistered': 4.00,
    'SatisfactionScore': 3.00,
    'NumberOfAddress': 3.00,
    'Complain': 0.00,
    'OrderAmountHikeFromlastYear': 15.00,
    'CouponUsed': 1.00,
    'OrderCount': 2.00,
    'DaySinceLastOrder': 4.00,
    'CashbackAmount': 163.28,
    'PreferredLoginDevice_Mobile Phone': 0.00,
    'PreferredLoginDevice_Phone': 0.00,
    'PreferredPaymentMode_COD': 0.00,
    'PreferredPaymentMode_Cash on Delivery': 0.00,
    'PreferredPaymentMode_Credit Card': 0.00,
    'PreferredPaymentMode_Debit Card': 0.00,
    'PreferredPaymentMode_E wallet': 0.00,
    'PreferredPaymentMode_UPI': 0.00,
    'Gender_Male': 1.00,
    'PreferedOrderCat_Grocery': 0.00,
    'PreferedOrderCat_Laptop & Accessory': 0.00,
    'PreferedOrderCat_Mobile': 0.00,
    'PreferedOrderCat_Mobile Phone': 0.00,
    'PreferedOrderCat_Others': 0.00,
    'MaritalStatus_Married': 1.00,
    'MaritalStatus_Single': 0.00
}

mandatory_features = [
    'Complain',
    'MaritalStatus_Single',
    'PreferedOrderCat_Mobile Phone',
    'PreferedOrderCat_Mobile',
    'MaritalStatus_Married',
    'CashbackAmount',
    'DaySinceLastOrder',
    'Tenure'
]

# All features the model expects (order should match training)
all_features = list(default_means.keys())
# Calculate the non-mandatory features:
other_features = [feat for feat in all_features if feat not in mandatory_features]

def create_full_input(user_input):
    """Merge default values with user-provided values."""
    full_input = default_means.copy()
    full_input.update(user_input)
    return pd.DataFrame([full_input])

@app.route('/', methods=['GET', 'POST'])
def index():
    if request.method == 'POST':
        user_inputs = {}
        for feature in all_features:
            value = request.form.get(feature)
            if feature in mandatory_features and (value is None or value.strip() == ''):
                return f"Error: The field {feature} is mandatory and must be filled.", 400
            elif value is None or value.strip() == '':
                user_inputs[feature] = default_means[feature]
            else:
                try:
                    user_inputs[feature] = float(value)
                except ValueError:
                    return f"Error: The field {feature} must be a number.", 400

        input_df = create_full_input(user_inputs)

        input_df = input_df[scaler.feature_names_in_]
        input_df_scaled = scaler.transform(input_df)
        
        prediction = model.predict(input_df_scaled)[0]
        prediction_prob = model.predict_proba(input_df_scaled)[0, 1]
        
        return render_template('result.html', prediction=prediction, probability=prediction_prob)
    
    return render_template('index.html', 
                           mandatory_features=mandatory_features, 
                           other_features=other_features,
                           default_values=default_means)

if __name__ == '__main__':
    app.run(debug=True)
