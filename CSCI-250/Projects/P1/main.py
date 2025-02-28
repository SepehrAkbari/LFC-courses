import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
import warnings
from sklearn.experimental import enable_iterative_imputer
from sklearn.impute import SimpleImputer
from sklearn.impute import IterativeImputer
from sklearn.ensemble import RandomForestRegressor
from imblearn.over_sampling import SMOTE
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler, PolynomialFeatures
from sklearn.linear_model import LinearRegression, LogisticRegression
from sklearn.metrics import confusion_matrix
from sklearn.metrics import mean_squared_error, r2_score, accuracy_score, classification_report, roc_auc_score

warnings.filterwarnings('ignore')

df = pd.read_excel('data.xlsx', sheet_name='E Comm')
desc = pd.read_excel('data.xlsx', sheet_name='Data Dict', header=1, usecols=[1,2,3]).drop(columns="Data")

df.drop(columns="CustomerID", inplace=True)

numerics = df.select_dtypes(include=['float64', 'int64']).columns.tolist()
df[numerics] = SimpleImputer(strategy='mean').fit_transform(df[numerics])

categoricals = df.select_dtypes(include=['object']).columns.tolist()
df = pd.get_dummies(df, columns=categoricals, drop_first=True)

rf_imputer = IterativeImputer(estimator=RandomForestRegressor(random_state=250), max_iter=10)
df = pd.DataFrame(rf_imputer.fit_transform(df), columns=df.columns)

X = df.drop(columns=["Churn"])
y = df["Churn"]

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=250, stratify=y)

smote = SMOTE(random_state=250)
X_train_resampled, y_train_resampled = smote.fit_resample(X_train, y_train)

## Shape of x_train, x_test, y_train, y_test: (7492, 29), (1126, 29), (7492,), (1126,)

scaler = StandardScaler()
X_train_scaled = scaler.fit_transform(X_train_resampled)
X_test_scaled = scaler.transform(X_test)

model_linear = LinearRegression()
model_linear.fit(X_train_scaled, y_train_resampled)
y_pred_linear = model_linear.predict(X_test_scaled)

plt.figure(figsize=(10, 6))
plt.scatter(range(len(y_test)), y_test, color='blue', label='Actual Churn', alpha=0.6)
plt.scatter(range(len(y_pred_linear)), y_pred_linear, color='red', label='Predicted Churn', alpha=0.6)
plt.title("Linear Regression: Actual vs. Predicted Churn")
plt.xlabel("Sample Index")
plt.ylabel("Churn")
plt.legend()
plt.show()