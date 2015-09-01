package test.checkpoint.andela.main;

import static org.junit.Assert.*;

import org.junit.Test;

import checkpoint.andela.main.Member;

public class MemberTest {

	@Test
	public void testMember(){
		Member member = new Member("James Harden",'M', "12/3/1988", "23243545");
		assertNotNull(member);
	}

}
