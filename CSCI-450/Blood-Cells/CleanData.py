import numpy as np
import os
import random
import shutil
from skimage import io

original_data_path = 'Data/bloodcells_dataset'
cleaned_data_path = 'Data/bloodcells_dataset_cleaned'
cell_types = ['basophil', 'eosinophil', 'erythroblast', 'ig', 'lymphocyte', 'monocyte', 'neutrophil', 'platelet']
target_shape = (363, 360, 3)
num_images_per_class = 500

def get_image_files(folder_path):
    valid_extensions = ('.png', '.jpg', '.jpeg')
    return [f for f in os.listdir(folder_path) if f.lower().endswith(valid_extensions)]

if not os.path.exists(cleaned_data_path):
    os.makedirs(cleaned_data_path)

for cell_type in cell_types:
    print(f"\nProcessing {cell_type}\n")
    src_folder = os.path.join(original_data_path, cell_type)
    dest_folder = os.path.join(cleaned_data_path, cell_type)
    
    if not os.path.exists(dest_folder):
        os.makedirs(dest_folder)
    
    image_files = get_image_files(src_folder)
    
    valid_images = []
    for fname in image_files:
        print(f"Processing {fname}")
        src_file_path = os.path.join(src_folder, fname)
        try:
            image = io.imread(src_file_path)
            if image.shape == target_shape:
                valid_images.append(fname)
        except Exception as e:
            print(f"Error processing {src_file_path}: {e}")

    if len(valid_images) < num_images_per_class:
        print(f"Warning: Only found {len(valid_images)} valid images for class {cell_type}.")
        selected_images = valid_images
    else:
        print(f"sampling {cell_type}")
        selected_images = random.sample(valid_images, num_images_per_class)
    
    for fname in selected_images:
        print(f"Finishing up {cell_type}")
        src_file_path = os.path.join(src_folder, fname)
        dest_file_path = os.path.join(dest_folder, fname)
        shutil.copy(src_file_path, dest_file_path)

print("\n\nData cleaning completed.\n")