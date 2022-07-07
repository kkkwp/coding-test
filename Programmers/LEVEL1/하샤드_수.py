# programmers, LEVEL1 : 하샤드 수
def solution(x):
    num = sum([int(c) for c in str(x)])
    return True if x%num==0 else False

# 최적코드
def solution(x):
    return x%sum([int(c) for c in str(x)])==0