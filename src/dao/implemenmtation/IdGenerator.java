package dao.implemenmtation;

public class IdGenerator {

	private int id = 0;

	public int generate() {
		return ++id;
	}
}
