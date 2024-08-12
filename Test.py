import random
name = random.choice(['Meera','Ben','John','Anand'])
score = random.randint(0,100)
if (score > 70):
    print(f"{name} perfomed really well in the test and got a score of {score}")
elif (score > 50 and score < 70):
    print(f" {name} passed the test and got a score of {score}")
else:
    print(f" {name} failed the test with a score of {score}")

x = "This is a string"
print(x)

x[3]
print(x[3])

x[0:4:3]
print(x[0:4:3])

x[3::]
print(x[3::])

a=0
while a<5:
    a+=1
    print(f'the value of a is {a}')

num = [0,1,2,3,4,5,6,7,8,9,10]
for x in num:
    if x==5:
        continue
    else:
        print(x)
    x+=1

list_num = [3,7,10]
list_num
list_set = {3,7,10}
list_tup = (3,7,10)

input()