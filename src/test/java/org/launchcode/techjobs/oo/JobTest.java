package org.launchcode.techjobs.oo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
        private Job job1;
        private Job job2;

        @Before
        public void setUp() {
            job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
            job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        }

        @Test
        public void testSettingJobId() {
            assertNotEquals(job1.getId(), job2.getId());

    }
    @Test
    public void testJobConstructorSetsAllFields() {
// Use instanceof to check the types of fields
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);

        // Use assertEquals to check each field's value
        assertEquals("Product tester", job1.getName());
        assertEquals("ACME", job1.getEmployer().getValue());
        assertEquals("Desert", job1.getLocation().getValue());
        assertEquals("Quality control", job1.getPositionType().getValue());
        assertEquals("Persistence", job1.getCoreCompetency().getValue());

        // Use assertTrue to check that the ID is greater than 0
        assertTrue(job1.getId() > 0);
    }
    @Test
    public void testJobsForEquality() {


        // Ensure that two Job objects with different IDs are not equal
        assertFalse(job1.equals(job2));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
       // Job job = new Job("Software Engineer", new Employer("Tech Company"), new Location("New York"),
                //new PositionType("Full Time"), new CoreCompetency("Java"));

        String jobString = job1.toString();

        assertTrue(jobString.startsWith("\n"));
        assertTrue(jobString.endsWith("\n"));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
       // Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String expected = "\n" +
                "ID: " + job1.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";

        assertEquals(expected, job1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job();  // Create a job object with no data

        String jobString = job.toString();

        String expectedString = "OOPS! This job does not seem to exist.";

        assertEquals(expectedString, jobString);
        }
}

