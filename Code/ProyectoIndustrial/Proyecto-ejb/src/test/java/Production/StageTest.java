package Production;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author daniel
 */
public class StageTest {

    //stage builder test
    @Test
    public void stageBuilderTest() throws Exception {
        // Arrange
        Integer idStageTest = 1;
        String nameTest = "teset";
        String descriptionTest = "test";
        int lineProductionIdTest = 2;
        int timeMinutesTest = 3;

        // Act
        Stage stageTest = new Stage(idStageTest, nameTest, descriptionTest, lineProductionIdTest, timeMinutesTest);
        Stage result = stageTest;
        // Assert
        Assert.assertEquals(result, stageTest);
    }

    //set and get of idStage test
    @Test
    public void testSetAndGetIdStage() throws Exception {
        // Arrange
        Stage testStage = new Stage();
        int testVal = 1;

        // Act
        testStage.setIdStage(testVal);
        int result = testStage.getIdStage();

        // Assert
        Assert.assertEquals(result, testVal);
    }

    //set and get of name test
    @Test
    public void testSetAndGetName() throws Exception {
        // Arrange
        Stage testStage = new Stage();
        String testVal = "test";

        // Act
        testStage.setName(testVal);
        String result = testStage.getName();

        // Assert
        Assert.assertEquals(result, testVal);
    }

    //set and get of description test
    @Test
    public void testSetAndGetDescription() throws Exception {
        // Arrange
        Stage testStage = new Stage();
        String testVal = "test";

        // Act
        testStage.setDescription(testVal);
        String result = testStage.getDescription();

        // Assert
        Assert.assertEquals(result, testVal);
    }

    

    //set and get of lineProductionId test
    @Test
    public void testSetAndGetLineProductionId() throws Exception {
        // Arrange
        Stage testStage = new Stage();
        int testVal = 1;

        // Act
        testStage.setLineProductionId(testVal);
        int result = testStage.getLineProductionId();

        // Assert
        Assert.assertEquals(result, testVal);
    }

    //set and get of timeMinutes test
    @Test
    public void testSetAndGetTimeMinutes() throws Exception {
        // Arrange
        Stage testStage = new Stage();
        int testVal = 1;

        // Act
        testStage.setTimeMinutes(testVal);
        int result = testStage.getTimeMinutes();

        // Assert
        Assert.assertEquals(result, testVal);
    }

    //equals test
    @Test
    public void testEquals() throws Exception {
        // Arrange
        Stage testStage = new Stage();
        Stage result = testStage;

        // Act
        testStage.equals(result);

        // Assert
        Assert.assertEquals(result, testStage);
    }

}
