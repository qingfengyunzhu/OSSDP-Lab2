import java.util.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Solution20 类的单元测试
 * 测试最小高度树算法的正确性
 */
public class L2023112660_20_Test {
    private Solution20 solution;

    /**
     * 在每个测试方法执行前初始化 Solution20 实例
     */
    @BeforeEach
    public void setUp() {
        solution = new Solution20();
    }

    /**
     * 测试目的：验证单节点树的特殊情况
     * 测试用例：n=1，无边的树
     * 预期结果：根节点只能是0
     */
    @Test
    public void testSingleNodeTree() {
        int n = 1;
        int[][] edges = {};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        List<Integer> expected = Arrays.asList(0);
        assertEquals(expected, result, "单节点树应该返回[0]");
    }

    /**
     * 测试目的：验证双节点树的情况
     * 测试用例：n=2，只有一条边的树
     * 预期结果：两个节点都可以作为根节点
     */
    @Test
    public void testTwoNodesTree() {
        int n = 2;
        int[][] edges = {{0,1}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        List<Integer> expected = Arrays.asList(0,1);
        assertTrue(areListsEqual(result, expected), 
                   "双节点树应该返回两个节点[0,1]");
    }

    /**
     * 测试目的：验证星形树的情况
     * 测试用例：n=4，中心节点1连接其他三个节点
     * 预期结果：只有中心节点1是最小高度树的根
     */
    @Test
    public void testStarTree() {
        int n = 4;
        int[][] edges = {{1,0},{1,2},{1,3}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        List<Integer> expected = Arrays.asList(1);
        assertEquals(expected, result, 
                     "星形树应该返回中心节点[1]");
    }

    /**
     * 测试目的：验证示例2中的复杂树结构
     * 测试用例：n=6，edges=[[3,0],[3,1],[3,2],[3,4],[5,4]]
     * 预期结果：节点3和4是最小高度树的根
     */
    @Test
    public void testComplexTreeWithTwoRoots() {
        int n = 6;
        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        List<Integer> expected = Arrays.asList(3,4);
        assertTrue(areListsEqual(result, expected), 
                   "复杂树应该返回两个根节点[3,4]");
    }

    /**
     * 测试目的：验证线性树（奇数节点数）的情况
     * 测试用例：n=5，线性连接 0-1-2-3-4
     * 预期结果：中间节点2是最小高度树的根
     */
    @Test
    public void testLinearTreeOddNodes() {
        int n = 5;
        int[][] edges = {{0,1},{1,2},{2,3},{3,4}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        List<Integer> expected = Arrays.asList(2);
        assertEquals(expected, result, 
                     "奇数节点线性树应该返回中间节点[2]");
    }

    /**
     * 测试目的：验证线性树（偶数节点数）的情况
     * 测试用例：n=6，线性连接 0-1-2-3-4-5
     * 预期结果：中间两个节点2和3是最小高度树的根
     */
    @Test
    public void testLinearTreeEvenNodes() {
        int n = 6;
        int[][] edges = {{0,1},{1,2},{2,3},{3,4},{4,5}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        List<Integer> expected = Arrays.asList(2,3);
        assertTrue(areListsEqual(result, expected), 
                   "偶数节点线性树应该返回中间两个节点[2,3]");
    }

    /**
     * 测试目的：验证更大规模的星形树
     * 测试用例：n=7，中心节点0连接其他六个节点
     * 预期结果：只有中心节点0是最小高度树的根
     */
    @Test
    public void testLargeStarTree() {
        int n = 7;
        int[][] edges = {{0,1},{0,2},{0,3},{0,4},{0,5},{0,6}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        List<Integer> expected = Arrays.asList(0);
        assertEquals(expected, result, 
                     "大型星形树应该返回中心节点[0]");
    }

    /**
     * 测试目的：验证不规则树结构
     * 测试用例：n=7，不规则连接
     * 预期结果：验证算法能正确处理不规则结构
     */
    @Test
    public void testIrregularTree() {
        int n = 7;
        int[][] edges = {{0,1},{1,2},{2,3},{1,4},{4,5},{4,6}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        // 这个测试主要验证算法不会崩溃，能返回有效结果
        assertNotNull(result, "不规则树应该返回非空结果");
        assertFalse(result.isEmpty(), "不规则树应该返回至少一个根节点");
    }

    /**
     * 辅助方法：比较两个列表是否包含相同元素（忽略顺序）
     * @param list1 第一个列表
     * @param list2 第二个列表
     * @return 如果两个列表包含相同元素则返回true
     */
    private boolean areListsEqual(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        return list1.containsAll(list2) && list2.containsAll(list1);
    }

    /**
     * 主方法：用于手动运行所有测试
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        L2023112660_20_Test test = new L2023112660_20_Test();
        
        System.out.println("开始执行 Solution20 测试...");
        
        // 执行所有测试方法
        test.setUp();
        test.testSingleNodeTree();
        System.out.println("✓ testSingleNodeTree 通过");
        
        test.setUp();
        test.testTwoNodesTree();
        System.out.println("✓ testTwoNodesTree 通过");
        
        test.setUp();
        test.testStarTree();
        System.out.println("✓ testStarTree 通过");
        
        test.setUp();
        test.testComplexTreeWithTwoRoots();
        System.out.println("✓ testComplexTreeWithTwoRoots 通过");
        
        test.setUp();
        test.testLinearTreeOddNodes();
        System.out.println("✓ testLinearTreeOddNodes 通过");
        
        test.setUp();
        test.testLinearTreeEvenNodes();
        System.out.println("✓ testLinearTreeEvenNodes 通过");
        
        test.setUp();
        test.testLargeStarTree();
        System.out.println("✓ testLargeStarTree 通过");
        
        test.setUp();
        test.testIrregularTree();
        System.out.println("✓ testIrregularTree 通过");
        
        System.out.println("所有测试通过！");
    }
}