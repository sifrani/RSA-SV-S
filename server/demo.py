import random

#creo le chiavi


prime = [71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139]
exp = [7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67]

p = prime[random.randrange(len(prime))]

q=0
while q!=p:
    q = prime[random.randrange(len(prime))]

n = p*q

phi = (p-1)*(q-1)

e = prime[random.randrange(len(exp))]

def extendedEuclide(a, b):
  if a == 0:
    return b, 0, 1
  else:
    x, y = extendedEuclide(b % a, a)
    return y - (b//a) * x, x

d, y = extendedEuclide(e, phi)

publicKey = (n, e)
privateKey = (n, d)


#creo il messaggio

m = 0b1110001010101100

def textToBinary(text):
    binaryString = ''.join(format(ord(char), '08b') for char in text)
    return binaryString


text = "[20:20, 21/10/2024] Visentin: parlato ho un a1 scritto pero c1 [20:21, 21/10/2024] Visentin: madre lingua"


binaryStrings = [textToBinary(text) ]
print("Binary representation:")
