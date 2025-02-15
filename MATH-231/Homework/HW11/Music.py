# pip install scipy simpleaudio

import numpy as np
import simpleaudio as sa

# Define parameters
SAMPLE_RATE = 44100  # Sampling frequency (Hz)
DURATION = 0.35  # Duration of each note or chord (seconds)

# Frequencies for the B Minor scale (in Hz)
B_MINOR_SCALE = {
    "B": 493.88,
    "C#": 554.37,
    "D": 587.33,
    "E": 659.25,
    "F#": 739.99,
    "G": 783.99,
    "A": 880.00,
    "B_high": 987.77
}

# Define some chords using the B Minor scale
CHORDS = {
    "Bm_first": ["B", "D", "F#"],
    "Cdim5": ["C#", "E", "G"],
    "Bm_second": ["B", "D", "F#"],
    "A6": ["A", "C#", "F#"],
    "Gmaj7": ["G", "B", "D", "F#"]
}

# Function to generate a sine wave for a given frequency
def generate_tone(frequency, duration=DURATION, sample_rate=SAMPLE_RATE):
    t = np.linspace(0, duration, int(sample_rate * duration), False)
    wave = np.sin(2 * np.pi * frequency * t)
    wave *= 32767 / np.max(np.abs(wave))  # Normalize to 16-bit range
    return wave.astype(np.int16)

# Function to generate a chord by summing multiple sine waves
def generate_chord(frequencies, duration=DURATION, sample_rate=SAMPLE_RATE):
    t = np.linspace(0, duration, int(sample_rate * duration), False)
    wave = sum(np.sin(2 * np.pi * freq * t) for freq in frequencies)
    wave *= 32767 / np.max(np.abs(wave))  # Normalize to 16-bit range
    return wave.astype(np.int16)

# Function to play a sound buffer
def play_sound(wave):
    play_obj = sa.play_buffer(wave, num_channels=1, bytes_per_sample=2, sample_rate=SAMPLE_RATE)
    play_obj.wait_done()

# Play individual notes
print("Playing B Minor Scale...")
for note, freq in B_MINOR_SCALE.items():
    print(f"Playing {note} ({freq} Hz)")
    wave = generate_tone(freq)
    play_sound(wave)

# Play chords
print("\nPlaying Chords...")
for chord, notes in CHORDS.items():
    freqs = [B_MINOR_SCALE[note] for note in notes]  # Get frequencies
    print(f"Playing {chord} ({', '.join(notes)})")
    wave = generate_chord(freqs)
    play_sound(wave)

print("Done!")