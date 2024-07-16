package com.Crud.ConsoleProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TaskConsoleProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskConsoleProjectApplication.class, args);
		TaskManager manager = new TaskManager();
		manager.run();
	}

	static class TaskManager {
		private final List<Task> tasks = new ArrayList<>();
		private final Scanner scanner = new Scanner(System.in);
		private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		private boolean running = true;

		public void run() {
			while (running) {
				System.out.println("1. Create Task");
				System.out.println("2. Read Tasks");
				System.out.println("3. Update Task");
				System.out.println("4. Delete Task");
				System.out.println("5. Particular Task");
				System.out.println("6. Delete All Tasks");
				System.out.println("7. Exit");
				System.out.print("Choose an option: ");
				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
					case 1:
						if (confirmOperation("Create a new task")) {
							createTask();
						}
						break;
					case 2:
						readTasks();
						break;
					case 3:
						if (confirmOperation("Update an existing task")) {
							updateTask();
						}
						break;
					case 4:
						if (confirmOperation("Delete a task")) {
							deleteTask();
						}
						break;
					case 5:
						getParticularTask();
						break;
					case 6:
						if (confirmOperation("Delete all tasks")) {
							deleteAllTasks();
						}
						break;
					case 7:
						exitTask();
						break;
					default:
						System.out.println("Invalid choice. Try again.");
				}
			}
		}

		private boolean confirmOperation(String operation) {
			System.out.print("Are you sure you want to " + operation + "? (yes/no): ");
			String response = scanner.nextLine();
			return response.equalsIgnoreCase("yes");
		}

		private void getParticularTask() {
			System.out.print("Enter Task ID: ");
			int taskId = scanner.nextInt();
			scanner.nextLine();
			boolean taskFound = false;
			for (Task task : tasks) {
				if (task.getId() == taskId) {
					System.out.println(task);
					taskFound = true;
					break;
				}
			}

			if (!taskFound) {
				System.out.println("Task not found");
			}
		}

		private void deleteAllTasks() {
			tasks.clear();
			System.out.println("All tasks deleted.");
		}

		private void readTasks() {
			if (tasks.isEmpty()) {
				System.out.println("No tasks available.");
			} else {
				for (Task task : tasks) {
					System.out.println(task);
				}
			}
		}

		private Status checkDate(Date currentDate, Date startDate, Date endDate) {
			if (startDate.equals(currentDate)) {
				return Status.ACTIVE;
			} else if (startDate.after(currentDate)) {
				return Status.SCHEDULED;
			} else if (endDate.before(currentDate)) {
				return Status.COMPLETED;
			} else {
				return Status.DISABLED;
			}
		}

		private boolean isAnnounced(Status status) {
			return status == Status.ACTIVE;
		}

		private void createTask() {
			try {
				System.out.print("Enter task name: ");
				String taskName = scanner.nextLine();

				System.out.print("Enter start date (yyyy-MM-dd HH:mm:ss): ");
				Date startDate = dateFormat.parse(scanner.nextLine());

				System.out.print("Enter end date (yyyy-MM-dd HH:mm:ss): ");
				Date endDate = dateFormat.parse(scanner.nextLine());

				System.out.print("Enter SOP title: ");
				String title = scanner.nextLine();

				System.out.print("Enter SOP description: ");
				String description = scanner.nextLine();

				System.out.print("Enter created by: ");
				String createdBy = scanner.nextLine();

				Date currentDate = new Date();
				Status status = checkDate(currentDate, startDate, endDate);
				boolean isAnnounced = isAnnounced(status);

				Task task = new Task(taskName, startDate, endDate, title, description, createdBy, status, isAnnounced);
				tasks.add(task);
				System.out.println("Task created successfully.");
			} catch (ParseException e) {
				System.out.println("Invalid date format. Please try again.");
			}
		}

		private void updateTask() {
			try {
				System.out.print("Enter task ID to update: ");
				int id = scanner.nextInt();
				scanner.nextLine();
				for (Task task : tasks) {
					if (task.getId() == id) {
						System.out.print("Enter new task name: ");
						task.setTaskName(scanner.nextLine());

						System.out.print("Enter new start date (yyyy-MM-dd HH:mm:ss): ");
						Date startDate = dateFormat.parse(scanner.nextLine());
						task.setStartDate(startDate);

						System.out.print("Enter new end date (yyyy-MM-dd HH:mm:ss): ");
						Date endDate = dateFormat.parse(scanner.nextLine());
						task.setEndDate(endDate);

						System.out.print("Enter new title: ");
						task.setTitle(scanner.nextLine());

						System.out.print("Enter new description: ");
						task.setDescription(scanner.nextLine());

						System.out.print("Enter new updated by: ");
						task.setUpdatedBy(scanner.nextLine());

						Date currentDate = new Date();
						Status status = checkDate(currentDate, startDate, endDate);
						task.setStatus(status);
						task.setIsAnnounced(isAnnounced(status));
						task.setUpdatedOn(new Date());

						System.out.println("Task updated successfully.");
						return;
					}
				}
				System.out.println("Task not found.");
			} catch (ParseException e) {
				System.out.println("Invalid date format. Please try again.");
			}
		}

		private void deleteTask() {
			System.out.print("Enter task ID to delete: ");
			int id = scanner.nextInt();
			scanner.nextLine();

			for (Task task : tasks) {
				if (task.getId() == id) {
					task.setDeletedBy("User");
					task.setDeletedOn(new Date());
					tasks.remove(task);
					System.out.println("Task deleted successfully.");
					return;
				}
			}
			System.out.println("Task not found.");
		}

		private void exitTask() {
			System.out.print("Are you sure you want to exit? (yes/no): ");
			String response = scanner.nextLine();
			if (response.equalsIgnoreCase("yes")) {
				running = false;
				System.out.println("Thank you for using this application.");
			}
		}
	}
}