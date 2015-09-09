package checkpoint.andela.main;

import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;

public class SubClassesCompare {

	public static int compareTo(Member member, Member member1) {
		int returnvalue = 0;
		if (member instanceof Student && member1 instanceof Staff) {
			return 1;
		} else if (member instanceof Staff && member1 instanceof Student) {
			return -1;
		} else if ((member instanceof Student && member1 instanceof Student)
				|| (member instanceof Member && member1 instanceof Member)) {
			if (member.getDateOfRegistration().compareTo(member1.getDateOfRegistration()) == 1) {
				returnvalue = 1;
			}
			if (member.getDateOfRegistration().compareTo(member1.getDateOfRegistration()) == -1) {
				returnvalue = -1;
			}
		}
		return returnvalue;
	}
}
