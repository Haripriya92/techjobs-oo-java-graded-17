package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;
    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType,
               CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }


    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        boolean hasData = (getName() != null&&!getName().isEmpty()) ||
                (getEmployer() != null && !getEmployer().getValue().isEmpty()) ||
                (getLocation() != null && !getLocation().getValue().isEmpty()) ||
                (getPositionType() != null && !getPositionType().getValue().isEmpty()) ||
                (getCoreCompetency() != null && !getCoreCompetency().getValue().isEmpty());

        if (hasData) {
            String idLabel = "ID: " + getId();
            String nameLabel = "Name: " + (getName() == null || getName().isEmpty() ? "Data not available" : getName());
            String employerLabel = "Employer: " + ((getEmployer() == null || getEmployer().getValue() == null || getEmployer().getValue().isEmpty()) ? "Data not available" : getEmployer().getValue());
            String locationLabel = "Location: " + ((getLocation() == null || getLocation().getValue() == null || getLocation().getValue().isEmpty()) ? "Data not available" : getLocation().getValue());
            String positionTypeLabel = "Position Type: " + ((getPositionType() == null || getPositionType().getValue() == null || getPositionType().getValue().isEmpty()) ? "Data not available" : getPositionType().getValue());
            String coreCompetencyLabel = "Core Competency: " + ((getCoreCompetency() == null || getCoreCompetency().getValue() == null || getCoreCompetency().getValue().isEmpty()) ? "Data not available" : getCoreCompetency().getValue());

            return "\n" +
                    idLabel + "\n" +
                    nameLabel + "\n" +
                    employerLabel + "\n" +
                    locationLabel + "\n" +
                    positionTypeLabel + "\n" +
                    coreCompetencyLabel + "\n";
        } else {
            return "OOPS! This job does not seem to exist.";
        }
    }


}
