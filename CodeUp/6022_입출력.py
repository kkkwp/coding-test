s = str(input())
result = []
cur = 0

for _ in range(3):
    result.append(s[cur:cur+2])
    cur+=2

print(' '.join(result))