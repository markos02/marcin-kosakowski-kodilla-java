package com.kodilla.patterns.prototype;

public final class Task {

    private final String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "      Task [" + name + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return name.equals(task.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
