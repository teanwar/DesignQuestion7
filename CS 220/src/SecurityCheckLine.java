import java.util.LinkedList;

interface LinePriority {
	// Adds the person with Ptype type to the current line based on his type
	public void AddPerson(String Person, String Ptype);

	// returns the first person on the line without removing
	public String GetFirst();

	// returns the first person from line and removes it
	public String Pop();

	// returns total number of people in line
	public int Size();

	// returns number of people in priority line
	public int PriorityLineSize();
}

public class SecurityCheckLine implements LinePriority {

	static LinkedList<String> Regulars;
	static LinkedList<String> HighPriorities;

	public SecurityCheckLine() {
		Regulars = new LinkedList<String>();
		HighPriorities = new LinkedList<String>();
	}

	// Ptype should be one of {"staff" , "VIP", "regular"}
	@Override
	public void AddPerson(String Person, String Ptype) {
		if (Ptype == "staff" || Ptype == "VIP") {
			// adds the person to the end of the list
			HighPriorities.add(Person);
		} else {
			// adds the person to the end of the regular list
			Regulars.add(Person);
		}
	}

	@Override
	public String GetFirst() {

		if (HighPriorities.size() > 0) {
			// there are high priority persons in the line - remove and return the first one
			return HighPriorities.getFirst();
		}
		if (Regulars.size() > 0) {
			// there are regulars in the line - remove and return the first one
			return Regulars.getFirst();
		}
		// no one in the line
		return null;
	}

	@Override
	public int Size() {
		// return the number of peoples in both lists
		return HighPriorities.size() + Regulars.size();
	}

	@Override
	public int PriorityLineSize() {
		// return number of people with high priority
		return HighPriorities.size();
	}

	@Override
	public String Pop() {
		if (HighPriorities.size() > 0) {
			// there are high priority persons in the line - remove and return the first one
			return HighPriorities.pop();
		}
		if (Regulars.size() > 0) {
			// there are regulars in the line - remove and return the first one
			return Regulars.pop();
		}
		// no one in the line
		return null;
	}

}
