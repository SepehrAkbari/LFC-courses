import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split, GridSearchCV
from sklearn.preprocessing import StandardScaler, LabelEncoder
from sklearn.svm import SVC
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import accuracy_score, precision_score, recall_score, f1_score, confusion_matrix, mean_squared_error, r2_score, classification_report
import xgboost as xgb
import matplotlib.pyplot as plt
import seaborn as sns

# Load the features CSV
feature_vector = pd.read_csv('bloodcells_dataset_cleaned_features.csv')

# Assume feature columns start with 'feat_'
feature_cols = [col for col in feature_vector.columns if col.startswith('feat_')]
X = feature_vector[feature_cols].values
y = feature_vector['label'].values

# Encode the string labels into numeric values (needed for MSE, R^2)
le = LabelEncoder()
y_encoded = le.fit_transform(y)

# Scale features
scaler = StandardScaler()
X_scaled = scaler.fit_transform(X)

# Train/test split (80/20, stratified)
X_train, X_test, y_train, y_test = train_test_split(X_scaled, y_encoded, test_size=0.2, random_state=42, stratify=y_encoded)

# Dictionary to store models and results
results = {}

# -----------------------------
# 1. Linear SVM
# -----------------------------
linear_svm = SVC(kernel='linear', random_state=42)
linear_svm.fit(X_train, y_train)
y_pred_linear = linear_svm.predict(X_test)
results['Linear SVM'] = y_pred_linear

# -----------------------------
# 2. Non-linear SVM (RBF) with GridSearchCV
# -----------------------------
param_grid = {
    'C': [0.1, 1, 10],
    'gamma': ['scale', 0.01, 0.001]
}
rbf_svm = SVC(kernel='rbf', random_state=42)
grid_svm = GridSearchCV(rbf_svm, param_grid, cv=5, n_jobs=-1)
grid_svm.fit(X_train, y_train)
y_pred_rbf = grid_svm.predict(X_test)
results['Non-linear SVM'] = y_pred_rbf
print("Best parameters for Non-linear SVM:", grid_svm.best_params_)

# -----------------------------
# 3. Random Forest
# -----------------------------
rf = RandomForestClassifier(random_state=42)
rf.fit(X_train, y_train)
y_pred_rf = rf.predict(X_test)
results['Random Forest'] = y_pred_rf

# -----------------------------
# 4. XGBoost
# -----------------------------
xgb_model = xgb.XGBClassifier(use_label_encoder=False, eval_metric='mlogloss', random_state=42)
xgb_model.fit(X_train, y_train)
y_pred_xgb = xgb_model.predict(X_test)
results['XGBoost'] = y_pred_xgb

# Function to compute and print metrics
def print_metrics(model_name, y_true, y_pred):
    mse = mean_squared_error(y_true, y_pred)
    r2 = r2_score(y_true, y_pred)
    accuracy = accuracy_score(y_true, y_pred)
    precision = precision_score(y_true, y_pred, average='weighted', zero_division=0)
    recall = recall_score(y_true, y_pred, average='weighted', zero_division=0)
    f1 = f1_score(y_true, y_pred, average='weighted', zero_division=0)
    cm = confusion_matrix(y_true, y_pred)
    
    print(f"\n--- {model_name} ---")
    print("MSE:", mse)
    print("R^2:", r2)
    print("Accuracy:", accuracy)
    print("Precision:", precision)
    print("Recall:", recall)
    print("F1 Score:", f1)
    print("\nClassification Report:")
    print(classification_report(y_true, y_pred, target_names=le.classes_))
    print("Confusion Matrix:")
    print(cm)
    
    # Plot confusion matrix
    plt.figure(figsize=(8,6))
    sns.heatmap(cm, annot=True, fmt='d', cmap='Blues', 
                xticklabels=le.classes_, yticklabels=le.classes_)
    plt.xlabel('Predicted Label')
    plt.ylabel('True Label')
    plt.title(f'Confusion Matrix: {model_name}')
    plt.show()

# Compute metrics for each model
for model_name, y_pred in results.items():
    print_metrics(model_name, y_test, y_pred)
