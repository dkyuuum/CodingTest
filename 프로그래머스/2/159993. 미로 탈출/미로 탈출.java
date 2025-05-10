/*
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        solution(maps);
    }

    public static int solution(String[] maps) {
        int xLen = maps.length;
        int yLen = maps[0].length();
        boolean[][] visited = new boolean[xLen][yLen];

        System.out.println(xLen+ ": " +yLen);

        return bfs(maps, 0, 0, visited);
        // return 0;
    }

    public static int bfs(String[] maps, int x, int y, boolean[][] visited) {
        Queue<Character> queue = new ArrayDeque<>(10000);

        int dist = 1;
        int xlen = maps.length;
        int ylen = maps[0].length();

        queue.add(maps[x].charAt(0));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            char s = queue.poll();
//            if (s.equals("O") && !visited[s]) {
//                queue.add(maps[s.charAt(0)]);
//                visited[s.charAt(0)][0] = true;
//            }
        }
        return 0;
    }
}*/

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        System.out.println(solution(maps));
    }

    public static int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        int sx = 0, sy = 0, lx = 0, ly = 0;

        // 시작점(S)과 레버(L) 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = maps[i].charAt(j);
                if (ch == 'S') {
                    sx = i;
                    sy = j;
                } else if (ch == 'L') {
                    lx = i;
                    ly = j;
                }
            }
        }

        // S → L, L → E
        int sToL = bfs(maps, sx, sy, 'L');
        int lToE = bfs(maps, lx, ly, 'E');

        if (sToL == -1 || lToE == -1) return -1;

        return sToL + lToE;
    }

    public static int bfs(String[] maps, int startX, int startY, char target) {
        int n = maps.length;
        int m = maps[0].length();

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (maps[x].charAt(y) == target) return dist;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m &&
                        !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist + 1});
                }
            }
        }

        return -1;
    }
}
