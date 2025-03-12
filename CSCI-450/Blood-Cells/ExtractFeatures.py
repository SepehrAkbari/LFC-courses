import os
import numpy as np
import pandas as pd
import random
import matplotlib.pyplot as plt
from skimage import io, color, filters, morphology, measure
from skimage.filters import gaussian, median, gabor
from skimage.morphology import disk
from skimage.feature import hog, local_binary_pattern
import warnings

warnings.filterwarnings('ignore')

def segment_cell(image, sigma=1, median_size=3, min_size=50, hole_area=50):
    gray_image = color.rgb2gray(image)
    smooth_image = gaussian(gray_image, sigma=sigma)
    smooth_image = median(smooth_image)
    thresh = filters.threshold_otsu(smooth_image)
    mask = smooth_image < thresh
    mask = morphology.remove_small_objects(mask, min_size=min_size)
    mask = morphology.remove_small_holes(mask, area_threshold=hole_area)
    labels = measure.label(mask)
    if labels.max() != 0:
        regions = measure.regionprops(labels)
        largest_region = max(regions, key=lambda r: r.area)
        mask = labels == largest_region.label
    segmented = image.copy()
    segmented[~mask] = 0
    return segmented, mask

def extract_color_histogram(image, num_bins=8):
    chans = []
    for i in range(3):
        hist, _ = np.histogram(image[:,:,i], bins=num_bins, range=(0, 255))
        hist = hist.astype("float")
        hist /= (hist.sum() + 1e-7)
        chans.extend(hist)
    return np.array(chans)

def extract_hog_features(image, pixels_per_cell=(16, 16), cells_per_block=(2, 2), orientations=9):
    gray = color.rgb2gray(image)
    features, _ = hog(gray, orientations=orientations, pixels_per_cell=pixels_per_cell,
                      cells_per_block=cells_per_block, block_norm='L2-Hys',
                      visualize=True, feature_vector=True)
    return features

def extract_lbp_features(image, radius=1, n_points=8, num_bins=10):
    gray = color.rgb2gray(image)
    lbp = local_binary_pattern(gray, n_points, radius, method='uniform')
    (hist, _) = np.histogram(lbp.ravel(), bins=num_bins, range=(0, num_bins))
    hist = hist.astype("float")
    hist /= (hist.sum() + 1e-7)
    return hist

def extract_gabor_features(image, frequency=0.6):
    gray = color.rgb2gray(image)
    filt_real, filt_imag = gabor(gray, frequency=frequency)
    mean_val = np.mean(filt_real)
    std_val = np.std(filt_real)
    return np.array([mean_val, std_val])

def extract_features(image):
    segmented, mask = segment_cell(image)
    
    color_feat = extract_color_histogram(segmented, num_bins=8)
    hog_feat = extract_hog_features(segmented, pixels_per_cell=(16,16), cells_per_block=(2,2), orientations=9)
    lbp_feat = extract_lbp_features(segmented, radius=1, n_points=8, num_bins=10)
    gabor_feat = extract_gabor_features(segmented, frequency=0.6)
    
    features = np.concatenate([color_feat, hog_feat, lbp_feat, gabor_feat])
    return features

cleaned_data_path = 'Data/bloodcells_dataset_cleaned'
cell_types = ['basophil', 'eosinophil', 'erythroblast', 'ig', 'lymphocyte', 'monocyte', 'neutrophil', 'platelet']

data_records = []

for cell_type in cell_types:
    print(f"\nStarting {cell_type}")
    folder_path = os.path.join(cleaned_data_path, cell_type)
    image_files = [f for f in os.listdir(folder_path) if f.lower().endswith(('.png', '.jpg', '.jpeg'))]
    
    for fname in image_files:
        print(f"Processing {fname}")
        file_path = os.path.join(folder_path, fname)
        try:
            image = io.imread(file_path)
            feats = extract_features(image)
            record = {
                'filename': file_path,
                'label': cell_type
            }
            for idx, val in enumerate(feats):
                record[f'feat_{idx}'] = val
            data_records.append(record)
        except Exception as e:
            print(f"Error processing {file_path}: {e}")
    print(f"{cell_type} done!\n")

print("\nSaving...")

df = pd.DataFrame(data_records)
df.to_csv('bloodcells_dataset_cleaned_features.csv', index=False)
print(f"Features saved")