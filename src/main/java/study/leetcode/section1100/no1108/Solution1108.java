package study.leetcode.section1100.no1108;

/**
 * <h2>Defanging an IP Address</h2>
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * <p>
 * A defanged IP address replaces every period "." with "[.]".
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 * </code></pre>
 * <b>Constraints:</b>
 * <pre>
 *     The given address is a valid IPv4 address.
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/defanging-an-ip-address/">
 * Defanging an IP Address</a>
 */
public class Solution1108 {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        String test = "192.168.1.1";
        Solution1108 solution1108 = new Solution1108();
        System.out.println(solution1108.defangIPaddr(test));
    }
}
