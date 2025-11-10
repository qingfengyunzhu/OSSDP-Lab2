import java.util.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    private Solution20 solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution20();
    }

    @Test
    public void testExample1() {
        int n = 4;
        int[][] edges = {{1,0},{1,2},{1,3}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        List<Integer> expected = Arrays.asList(1);
        assertEquals(expected, result, "示例1测试失败");
    }

    @Test
    public void testExample2() {
        int n = 6;
        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        List<Integer> expected = Arrays.asList(3,4);
        assertTrue(result.containsAll(expected) && expected.containsAll(result) && result.size() == expected.size(), 
                  "示例2测试失败");
    }

    @Test
    public void testSingleNode() {
        int n = 1;
        int[][] edges = {};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        List<Integer> expected = Arrays.asList(0);
        assertEquals(expected, result, "单节点测试失败");
    }

    @Test
    public void testTwoNodes() {
        int n = 2;
        int[][] edges = {{0,1}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        List<Integer> expected = Arrays.asList(0,1);
        assertTrue(result.containsAll(expected) && expected.containsAll(result) && result.size() == expected.size(), 
                  "两节点测试失败");
    }

    @Test
    public void testLinearTree() {
        int n = 5;
        int[][] edges = {{0,1},{1,2},{2,3},{3,4}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        List<Integer> expected = Arrays.asList(2);
        assertEquals(expected, result, "线性树测试失败");
    }

    @Test
    public void testStarTree() {
        int n = 7;
        int[][] edges = {{0,1},{0,2},{0,3},{0,4},{0,5},{0,6}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        List<Integer> expected = Arrays.asList(0);
        assertEquals(expected, result, "星形树测试失败");
    }

    @Test
    public void testEvenDiameter() {
        int n = 7;
        int[][] edges = {{0,1},{1,2},{2,3},{3,4},{4,5},{5,6}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        List<Integer> expected = Arrays.asList(3);
        assertEquals(expected, result, "偶数直径测试失败");
    }

    public static void main(String[] args) {
        org.junit.platform.console.ConsoleLauncher.main(
            "--select-class", SolutionTest.class.getName()
        );
    }
}