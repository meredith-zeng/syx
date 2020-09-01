import com.protecthair.dao.TeamMapper;
import com.protecthair.controller.TeamController;
import com.protecthair.domain.Team;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TeamTest {
    private static final Log logger = LogFactory.getLog(TeamController.class);
    @Autowired TeamMapper teamMapper;
    @Test
    public void newTeam() {
        Team team=new Team();
        team.setTeamName("A");
        team.setTeamCollege("B");
        team.setTeamLeaderStudentId(1);
        team.setTeamLeaderStudentName("C");
        team.setTeamLevel("1");
        teamMapper.insert(team);
//        logger.info(supplierMapper.selectSupplier(2));
    }
    @Test
    public void editTeam() {
        Team team=new Team();
        team.setTeamId(5);
        team.setTeamName("AAAAAAA");
        team.setTeamCollege("BBBBBB");
        team.setTeamLeaderStudentId(112313);
        team.setTeamLeaderStudentName("CCCCCCC");
        team.setTeamLevel("1");
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


        System.out.println(teamMapper.search("1"));
//        logger.info(supplierMapper.selectSupplier(2));
    }
    @Test
    public void rmTeam() {


        teamMapper.deleteByPrimaryKey(3);
//        logger.info(supplierMapper.selectSupplier(2));
    }

}
