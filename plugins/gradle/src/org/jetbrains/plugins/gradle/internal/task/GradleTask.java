package org.jetbrains.plugins.gradle.internal.task;

import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskId;
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskNotificationListener;
import com.intellij.openapi.progress.ProgressIndicator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Denis Zhdanov
 * @since 1/24/12 7:16 AM
 */
public interface GradleTask {

  @NotNull
  ExternalSystemTaskId getId();

  @NotNull
  GradleTaskState getState();

  /**
   * @return    error occurred during the task execution (if any)
   */
  @Nullable
  Throwable getError();

  /**
   * Executes current task and updates given indicator's {@link ProgressIndicator#setText2(String) status} during that.
   * 
   * @param indicator  target progress indicator
   * @param listeners  callbacks to be notified on task execution update
   */
  void execute(@NotNull ProgressIndicator indicator, @NotNull ExternalSystemTaskNotificationListener... listeners);
  
  /**
   * Executes current task at the calling thread, i.e. the call to this method blocks.
   * 
   * @param listeners  callbacks to be notified about the task execution update
   */
  void execute(@NotNull ExternalSystemTaskNotificationListener... listeners);

  /**
   * Forces current task to refresh {@link #getState() its state}.
   */
  void refreshState();
}
