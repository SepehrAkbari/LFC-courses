import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from skimage import io, transform, feature, color, filters, measure, morphology
from scipy import stats
import os
import random

BloodCells = '/Data/bloodcells_dataset'
cell_types = ['basophil', 'eosinophil', 'erythroblast', 'ig', 'lymphocyte', 'monocyte', 'neutrophil', 'platelet']

def get_image_files(folder):
    return [f for f in os.listdir(folder) if f.lower().endswith(('.png', '.jpg', '.jpeg'))]

counts = {}
for cell_type in cell_types:
    folder_path = os.path.join(BloodCells, cell_type)
    image_files = get_image_files(folder_path)
    counts[cell_type] = len(image_files)

print("Number of images per cell type:\n")
for cell_type, count in counts.items():
    print(f"{cell_type}: {count}")