package checkpoint.andela.main;

import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;

public class MemberCompare {

	public static int compareTo(Member member, Member member1) {
		if (member instanceof Student && member1 instanceof Staff) {
			return 1;
		} else if (member instanceof Staff && member1 instanceof Student) {
			return -1;
		} else {
			return member.getDateOfRegistration().compareTo(member1.getDateOfRegistration());
		}
	}
}
