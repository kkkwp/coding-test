# programmers, LEVEL1 : 하샤드 수
def solution(x):
    return x % sum([int(c) for c in str(x)]) == 0

# 최적코드
def solution(x):
    return x % sum(list(map(int, str(x)))) == 0