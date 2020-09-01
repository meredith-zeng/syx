import com.protecthair.dao.TeamMemberMapper;
import com.protecthair.controller.TeamMemberController;
import com.protecthair.domain.TeamMember;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class MemberTest {
    private static final Log logger = LogFactory.getLog(TeamMemberController.class);
    @Autowired TeamMemberMapper teamMapper;
    @Test
    public void newTeam() {
        TeamMember team=new TeamMember();
        team.setTeamName("A");
        team.setIsLeader("No");
        team.setTeamMemberName("wer");
        team.setStudentId("41233");
        team.setTeamMemberCollege("dffffaasaa");
        team.setTeamMemberMajor("gjjj");
        teamMapper.insert(team);
//        logger.info(supplierMapper.selectSupplier(2));
    }
    @Test
    public void editTeam() {
        TeamMember team=new TeamMember();
        team.setTeamMemberId(1);
        team.setTeamName("A");
        team.setIsLeader("No");
        team.setTeamMemberName("wer");
        team.setStudentId("41233");
        team.setTeamMemberCollege("dffffaasaa");
        team.setTeamMemberMajor("gjjj");
        teamMapper.updateByPrimaryKey(team);
//        logger.info(supplierMapper.selectSupplier(2));
    }
    @Test
    public void findTeam() {


        System.out.println(teamMapper.selectByPrimaryKey(5));
//        logger.info(supplierMapper.selectSupplier(2));
    }
    @Test
    public void schTeam() {


        System.out.println(teamMapper.find("1"));
//        logger.info(supplierMapper.selectSupplier(2));
    }
    @Test
    public void rmTeam() {


        teamMapper.deleteByPrimaryKey(3);
//        logger.info(supplierMapper.selectSupplier(2));
    }

}
