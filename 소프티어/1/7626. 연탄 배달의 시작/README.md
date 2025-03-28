# [level 1] 연탄 배달의 시작 - 7626 

[문제 링크](https://softeer.ai/practice/7626) 

### 성능 요약

메모리: 10.56 MB, 시간: 80 ms

### 구분

Challenge > 연습문제 > 알고리즘

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2025년 02월 06일 03:00:44

### 문제 설명

<p>산타는 연탄 배달을 시작하려고 합니다. 이 도시에는 n개의 마을이 있고, 각 마을은 1차 수직선 상에 위치하고 있습니다. </p>

![](https://softeer.ai/upload/2024/01/20240129_200044566_28989.png)

<p>산타는 이 마을들 중 가장 거리가 가까운 두 마을을 먼저 방문한다고 했을 때, 산타가 처음 방문할 가능성이 있는 서로 다른 두 마을 조합의 수를 구하는 프로그램을 작성해보세요. </p>

> 본 문제의 저작권은 (주)브랜치앤바운드에 있으며, 저작자의 동의 없이 무단 전재/복제/배포를 금지합니다.

<h5>제약조건</h5>

<p>2 ≤ n ≤ 1,000</p>
<p>1 ≤ 마을의 위치 ≤ 1,000,000</p>

<h5>입력형식</h5>

<p>첫 번째 줄에는 마을의 수를 나타내는 n이 주어집니다.</p>

<p>두 번째 줄에는 n개의 마을의 위치가 공백을 사이에 두고 주어집니다. 마을의 위치는 서로 다르며, 이 위치들은 오름차순으로 주어진다고 가정해도 좋습니다.</p>

<h5>출력형식</h5>

<p>첫 번째 줄에 산타가 처음 방문할 가능성이 있는 서로 다른 두 마을 조합의 수를 출력합니다.</p>

<h5>입력예제1</h5>

```
5
1 3 5 8 10
```

<h5>출력예제1</h5>

```
3
```

<p>첫 번째 예제에서 가장 가까운 두 마을간의 거리는 2입니다. 이것이 가능한 두 마을 위치의 조합은 {1, 3}, {3, 5}, {8, 10} 이렇게 3개이기에 답은 3이 됩니다.</p>

<h5>입력예제2</h5>

```
5
1 3 5 7 8
```

<h5>출력예제2</h5>

```
1
```

<p>두 번째 예제에서 가장 가까운 두 마을간의 거리는 1입니다. 이것이 가능한 두 마을 위치의 조합은 {7, 8} 밖에 없기에 답은 1이 됩니다.</p>