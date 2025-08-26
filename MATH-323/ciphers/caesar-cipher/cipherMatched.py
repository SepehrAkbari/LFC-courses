from caesar import ALPHABET, ALPHABET_LENGTH, encrypt

try:
    with open('words.txt', 'r') as file:
        words = file.read().splitlines()
except FileNotFoundError:
    print("Error: File not found.")
    exit()

words = [word.strip() for word in words if word.strip().isalpha()]
words = [word.upper() for word in words if len(word) >= 4]
words = set(words)
words_sorted = sorted(list(words))

matches = []
for i, word in enumerate(words_sorted):
    if (i + 1) % 10000 == 0:
        print(f"Processed {i + 1}/{len(words_sorted)} words.")

    for shift in range(1, ALPHABET_LENGTH):
        ciphered = encrypt(word, shift)
        if ciphered in words:
            if word < ciphered:
                matches.append((word, ciphered, shift))

print(f"\nFound {len(matches)} unique pairs.")

if not matches:
    print("No matches were found.")
    exit()

max_len = 0
for word1, word2, _ in matches:
    max_len = max(max_len, len(word1), len(word2))

matches_longest = []
for word1, word2, shift in matches:
    if len(word1) == max_len or len(word2) == max_len:
        matches_longest.append((word1, word2, shift))

print(f"Number of pairs with the longest length ({max_len} characters): {len(matches_longest)}\n")

for pair in matches_longest:
    print(f"Pair: {pair[0]} and {pair[1]} (Shift: {pair[2]})")