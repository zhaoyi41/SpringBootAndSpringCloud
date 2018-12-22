package cn.zyz;

public class PaixuTest {
	/**
	 * ���ҳ����ᣨĬ�������λlow������numbers�������������λ��
	 * 
	 * @param numbers ����������
	 * @param low     ��ʼλ��
	 * @param high    ����λ��
	 * @return ��������λ��
	 */
	public static int getMiddle(int[] numbers, int low, int high) {
		int temp = numbers[low]; // ����ĵ�һ����Ϊ����
		while (low < high) {
			while (low < high && numbers[high] > temp) {
				high--;
			}
			numbers[low] = numbers[high];// ������С�ļ�¼�Ƶ��Ͷ�
			while (low < high && numbers[low] < temp) {
				low++;
			}
			numbers[high] = numbers[low]; // �������ļ�¼�Ƶ��߶�
		}
		numbers[low] = temp; // �����¼��β
		return low; // ���������λ��
	}

	/**
	 * 
	 * @param numbers ����������
	 * @param low     ��ʼλ��
	 * @param high    ����λ��
	 */
	public static void quickSort(int[] numbers, int low, int high) {
		if (low < high) {
			int middle = getMiddle(numbers, low, high); // ��numbers�������һ��Ϊ��
			quickSort(numbers, low, middle - 1); // �Ե��ֶα���еݹ�����
			quickSort(numbers, middle + 1, high); // �Ը��ֶα���еݹ�����
		}

	}

	/**
	 * ��������
	 * 
	 * @param numbers ����������
	 */
	public static void quick(int[] numbers) {
		if (numbers.length > 0) // �鿴�����Ƿ�Ϊ��
		{
			quickSort(numbers, 0, numbers.length - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] s = {6,4,7,9,8,22,32,5431,234,24,23};
		PaixuTest.quick(s);
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]+",");
		}
	}
}
