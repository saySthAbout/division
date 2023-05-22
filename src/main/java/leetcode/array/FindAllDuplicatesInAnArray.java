package leetcode.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAllDuplicatesInAnArray {
    // https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    public static void main(String[] args) throws IOException {
        int count = 0;					// 입력받을 배열의 크기
        int[] num;						// 입력받을 숫자

        Scanner scanner = new Scanner(System.in);
        // 배열의 크기 입력받기
        System.out.print("배열의 크기는? (100개 미만) : ");
        count = scanner.nextInt();
        num = new int[count];

        // 숫자 입력받기
        System.out.print(count + " 개의 숫자를 입력하세요! : ");
        for (int i = 0 ; i < count ; i++) {
            num[i] = scanner.nextInt();
        }
        List<Integer> result = findDuplicates(num);
        System.out.println(result);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }

}
