import random

ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".upper()
ALPHABET_LENGTH = len(ALPHABET)

def encrypt(plain_text: str, key: str) -> str:
    ciphered = ""
    for char in plain_text.upper():
        if char in ALPHABET:
            idx = ALPHABET.index(char)
            cipher_char = key[idx]
            ciphered += cipher_char
        else:
            ciphered += char
    return ciphered

def decrypt(ciphered_text: str, key: str) -> str:
    plain_text = ""
    for char in ciphered_text.upper():
        if char in ALPHABET:
            idx = key.index(char)
            plain_char = ALPHABET[idx]
            plain_text += plain_char
        else:
            plain_text += char
    return plain_text

def generateRandomKey() -> str:
    return ''.join(random.sample(ALPHABET, ALPHABET_LENGTH))

def generatePasswordKey(password: str) -> str:
    password = ''.join(filter(str.isalpha, password))
    password = password.upper()
    password = password.replace(" ", "")
    seen = set()
    password = ''.join([char for char in password if not (char in seen or seen.add(char))])

    key = ""
    for char in password:
        if char not in key and char in ALPHABET:
            key += char
    
    idx_current = ALPHABET.index(key[-1]) + 1 if key else 0
    for i in range(ALPHABET_LENGTH):
        idx = (idx_current + i) % ALPHABET_LENGTH
        if ALPHABET[idx] not in key:
            key += ALPHABET[idx]

    return key

def returnCiphered(ciphered: str) -> str:
    ciphered = ''.join(filter(str.isalpha, ciphered))
    ciphered = ciphered.upper()
    ciphered = ciphered.replace(" ", "")

    chunked = [ciphered[i:i+5] for i in range(0, len(ciphered), 5)]
    return ' '.join(chunked)

if __name__ == "__main__":
    text = ""
    enc = ""
    key = ""

    # print(f"Original Text: {text}\nEncrypted: {returnCiphered(encrypt(text, key))}\nDecrypted: {decrypt(encrypt(text, key), key)}")