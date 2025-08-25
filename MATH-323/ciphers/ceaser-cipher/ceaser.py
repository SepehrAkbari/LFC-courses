ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".upper()
ALPHABET_LENGTH = len(ALPHABET)

def encrypt(plain_text, shift):
    ciphered = ""
    for char in plain_text.upper():
        if char in ALPHABET:
            idx = ALPHABET.index(char)
            cipher_char = ALPHABET[(idx + shift) % ALPHABET_LENGTH]
            ciphered += cipher_char
        else:
            ciphered += char
    return ciphered

def decrypt(ciphered_text, shift):
    plain_text = ""
    for char in ciphered_text.upper():
        if char in ALPHABET:
            idx = ALPHABET.index(char)
            plain_char = ALPHABET[(idx - shift) % ALPHABET_LENGTH]
            plain_text += plain_char
        else:
            plain_text += char
    return plain_text

def returnCiphered(ciphered):
    ciphered = ''.join(filter(str.isalpha, ciphered))
    ciphered = ciphered.upper()
    ciphered = ciphered.replace(" ", "")

    chunked = [ciphered[i:i+5] for i in range(0, len(ciphered), 5)]
    return ' '.join(chunked)

if __name__ == "__main__":
    text = "This is a, ceaser cipher!"
    shift = 3
    
    print(f"Original Text: {text}\nEncrypted: {returnCiphered(encrypt(text, shift))}\nDecrypted: {decrypt(encrypt(text, shift), shift)}")