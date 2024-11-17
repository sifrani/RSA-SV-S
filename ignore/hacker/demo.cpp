#include <iostream>
#include <string>
#include <vector>

using namespace std;

int prime[] = {1009, 1013, 1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087, 1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151,
        1153, 1163, 1171, 1181, 1187, 1193, 1201, 1213, 1217, 1223, 1229, 1231, 1237, 1249, 1259, 1277, 1279, 1283, 1289, 1291, 1297, 1301,
        1303, 1307, 1319, 1321, 1327, 1361, 1367, 1373, 1381, 1399, 1409, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453, 1459, 1471, 1481,
        1483, 1487, 1489, 1493, 1499, 1511, 1523, 1531, 1543, 1549, 1553, 1559, 1567, 1571, 1579, 1583, 1597, 1601, 1607, 1609, 1613, 1619,
        1621, 1627, 1637, 1657, 1663, 1667, 1669, 1693, 1697, 1699, 1709, 1721, 1723, 1733, 1741, 1747, 1753, 1759, 1777, 1783, 1787, 1789, 
        1801, 1811, 1823, 1831, 1847, 1861, 1867, 1871, 1873, 1877, 1879, 1889, 1901, 1907, 1913, 1931, 1933, 1949, 1951, 1973, 1979, 1987, 
        1993, 1997, 1999};

int exp[] = {7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67};


int main() {
    std::cout << "Hello World!";




    p = prime[random.randrange(len(prime))]

    q = prime[random.randrange(len(prime))]
    while q==p:
        q = prime[random.randrange(len(prime))]

    n = p*q

    phi = (p-1)*(q-1)

    e = exp[random.randrange(len(exp))]

        
    gd, x,  d = gcdExtended(phi, e)

    //print(f"r: {(phi*s)+(e*d)}")

    print(f"x: {x}, y: {d}, a: {phi}, b: {e}")

    publicKey = (n, e)
    privateKey = (n, d)

    print(f"p: {p}, q: {p}, n: {n}, phi: {phi}")
    print(f"publicKey: {publicKey}")
    print(f"privateKey: {privateKey}")
    //creo il messaggio


def textToBinary(text):
    n=0
    for c in text:
        n += ord(c)
        n<<=8
    n>>=8
    return n


text = "[20:20, 21/10/2024] Visentin: parlato ho un a1 scritto pero c1 [20:21, 21/10/2024] Visentin: madre lingua"
print(f"text: {text}")

l = 0

n_ = n
while n_>=256:
   n_>>=8
   l+=1

binaryStrings = [textToBinary(text[i:i+l]) for i in range(0,len(text), l)]
print(f"\nbinaryStrings: {binaryStrings}")

cryptedPackets = [(x**e)%n for x in binaryStrings]

#decrypto


print(f"\ncryptedPackets: {cryptedPackets}")
decryptedPackets = [(x**d)%n for x in cryptedPackets]
print(f"\ndecryptedPackets: {decryptedPackets}")

decryptedText = ""
for x in decryptedPackets:
    decryptedText += binaryToText(x)



print(f"decryptedText: {decryptedText}")
    return 0;
}


string binaryToText(int n){
    vector<int> bytesN = {};
    while (n != 0){
        bytesN.push_back(n%256);
        n>>=8;
    }
    string text = "";
    for (int byte : bytesN) {
        text = (char)(byte) + text;
    }
    return text;
}


int[] gcdExtended(int a, int b){
    if (a == 0) {
        return {b,0,1};
    }         
    gcd,x1,y1 = gcdExtended(b%a, a);

    int x = y1 - (b//a) * x1;
    int y = x1;
     
    return {gcd, x, y}
}