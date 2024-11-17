import numpy as np

def is_prime(num):
    """Funzione per verificare se un numero è primo"""
    if num <= 1:
        return False
    if num <= 3:
        return True
    if num % 2 == 0 or num % 3 == 0:
        return False
    i = 5
    while i * i <= num:
        if num % i == 0 or num % (i + 2) == 0:
            return False
        i += 6
    return True

# Genera una lista di numeri a partire da 1001
numbers = np.arange(1001, 2000)

# Filtra la lista per trovare i numeri primi
primes = numbers[np.vectorize(is_prime)(numbers)]

print([int(p) for p in primes])