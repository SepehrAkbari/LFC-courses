from substitution import *
from itertools import product

min_len = 3
max_len = 6
charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

ciphered = "WBJGW RBGRC BRKHW RJKCK RZZDR CDZRW BJLGV TNTPT JKCIR LBERH JKCCE IPRMR HPCBR JCARK VWBUK VTKBC CBRRM RHYBR NIRSC HRILK WBDCR KHPWK JKVRR OTGKC DDCJW KR"

try:
    with open('words.txt', 'r') as file:
        words = set(word.strip().upper() for word in file)
        words.update({"A", "I", "THE", "AND"})
except FileNotFoundError:
    print("Error: File not found.")
    exit()

ciphertext_clean = ciphered.replace(" ", "").upper()

for length in range(min_len, max_len + 1):
    for password_guess_tuple in product(charset, repeat=length):
        password_guess = "".join(password_guess_tuple)
        key = generatePasswordKey(password_guess)
        dec_text = decrypt(ciphertext_clean, key)

        dec_words = dec_text.split()

        found = 0
        for word in words:
            if word in dec_words:
                found += 1

        if found >= 1:
            print(f"{dec_text}")
