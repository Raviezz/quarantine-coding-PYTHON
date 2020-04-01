"""
Minimum splits required to convert a number into prime segments.

Given a number in the form of a string s, the task is to calculate and display minimum splits required such that
the segments formed are Prime or print Not Possible otherwise.

Input: s = “2351”
Output : 0
Explanation: Given number is already prime.

Input: s = “2352”
Output: 2
Explanation: Resultant prime segments are 23,5,2

Input: s = “2375672”
Output : 2
Explanation: Resultant prime segments are 2,37567,2


"""


def is_input_valid(number):
    try:
        int(number)
        return True
    except Exception as e:
        print(f"The entered number in invalid.\n{e}\nTry again")
        return False


def get_splits(number):
    """
    This is a straightforward tree search algorithm.
    Each node checks a scenario and returns the minimum number of splits from it's subtree.

    To see how each node works, lets take an example with input number as 1234.
    In the first level of the tree, the nodes would have stats as:
    node1: [1*, 2,3,4]  - This means that the substring 1 is found to be prime.
    node2: [1*,2*, 3,4]  - This means that the substring 12 is found to be prime.
    node3: [1*,2*,3*, 4]  - This means that the substring 123 is found to be prime.
    node4: [1*, 2*, 3*, 4*] - The whole string is found to be prime. So this node will return 0 to the parent.
    node5: [1,2,3,4]  - In this case, none of the substring starting with 1 was prime. So it is not possible to
                        split to make prime numbers. This node will return None.

    Level2:
    node1.1 (1st child of node1): [1, 2*, 3, 4] - This means that, after finding out that substring 1 is prime,
                                                  We found that substring 2 is prime.
    node1.2 (2nd child of node1): [1, 2*, 3*, 4] - This means that, after finding out that substring 1 is prime,
                                                  We found that substring 23 is prime.
    This would continue in the similar fashion.

    Once all the nodes in a level are computed, the minimum value returned values of all nodes is returned to parent.

    :param number: String of integer.
    :return: Minimum number of splits.
    """
    # TODO: Implement get_splits


def main():
    number = input("Enter a number: ")
    if not is_input_valid(number):
        return main()

    print(get_splits(number))


if __name__ == "__main__":
    main()
