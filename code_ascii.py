def sum_ascii(mot):
    mot=mot.upper()
    sum=0
    for lettre in mot:
        if lettre!=" ":
            sum+=ord(lettre)
            print(lettre,"=",ord(lettre))
    return sum

mot =input("Entrer nom complet suivi du matricule : ")
w=sum_ascii(mot)
print("total code ascii : {}".format(w))
for i in range(5):
    print(w%24+i,end="\t")

print("\n")