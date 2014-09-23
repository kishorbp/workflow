package com.nirmata.workflow.models;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class TaskDagModel
{
    private final TaskId taskId;
    private final List<TaskDagModel> children;

    public TaskDagModel(TaskId taskId, List<TaskDagModel> children)
    {
        this.taskId = Preconditions.checkNotNull(taskId, "taskId cannot be null");
        children = Preconditions.checkNotNull(children, "children cannot be null");
        this.children = ImmutableList.copyOf(children);
    }

    public TaskId getTaskId()
    {
        return taskId;
    }

    public List<TaskDagModel> getChildren()
    {
        return children;
    }

    @Override
    public boolean equals(Object o)
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }

        TaskDagModel that = (TaskDagModel)o;

        if ( !children.equals(that.children) )
        {
            return false;
        }
        //noinspection RedundantIfStatement
        if ( !taskId.equals(that.taskId) )
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = taskId.hashCode();
        result = 31 * result + children.hashCode();
        return result;
    }

    @Override
    public String toString()
    {
        return "TaskDagModel{" +
            "taskId=" + taskId +
            ", children=" + children +
            '}';
    }
}