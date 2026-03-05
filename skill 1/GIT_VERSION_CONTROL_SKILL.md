# Git Version Control - Skill 1 Tutorial

## Introduction
Git Version Control is used to manage and track changes in project files. It helps developers work together by saving different versions of code safely. Using Git, we can create branches, make updates, and merge changes without losing data. This skill helps us understand how real software teams collaborate and manage their projects efficiently.

---

## STEP 1: Initialize Git and Configure User

### Commands to execute in Git Bash or Terminal:

```bash
# 1. Create a new folder
mkdir git-project
cd git-project

# 2. Initialize Git
git init

# 3. Configure username and email
git config user.name "Your Name"
git config user.email "your.email@example.com"

# 4. Verify configuration
git config --list
```

---

## STEP 2: Create Files and Add to Staging

### Commands:

```bash
# 1. Create two files
touch main.java
touch notes.txt

# 2. Add sample content to main.java
echo "public class Main {
    public static void main(String[] args) {
        System.out.println(\"Hello Git!\");
    }
}" > main.java

# 3. Add sample content to notes.txt
echo "Git Version Control Notes
========================
- Initialize with: git init
- Check status: git status
- Add to staging: git add filename
- Commit: git commit -m \"message\"" > notes.txt

# 4. Check repository status (files will appear in red - untracked)
git status

# 5. Add files to staging
git add main.java
git add notes.txt
# OR add all files: git add .

# 6. Check status again (files will appear in green - staged)
git status
```

---

## STEP 3: Commit the Staged Files

### Commands:

```bash
# Commit with a meaningful message
git commit -m "Initial commit: Added main.java and notes.txt"

# Verify commit
git log
```

---

## STEP 4: Connect to GitHub and Push (SKIPPED - No Push)

### Note: This step would require:
1. Creating a new repository on GitHub named "git-skill1" (Public, no README)
2. Copying the repository URL
3. Connecting local repo: `git remote add origin <repository-url>`
4. Pushing: `git push -u origin main`

**This step is NOT executed as per user instruction.**

---

## STEP 5: Create First Branch (feature-update)

### Commands:

```bash
# 1. Create and switch to new branch
git checkout -b feature-update

# 2. Modify file (example: add new content to main.java)
echo "public class Main {
    public static void main(String[] args) {
        System.out.println(\"Hello Git!\");
        System.out.println(\"Feature update applied!\");
    }
}" > main.java

# 3. Add and commit changes
git add main.java
git commit -m "Added feature update to main.java"
```

---

## STEP 6: Create Second Branch (bug-fix)

### Commands:

```bash
# 1. Switch to main branch
git checkout main

# 2. Create new branch
git checkout -b bug-fix

# 3. Modify file (example: fix a bug in main.java)
echo "public class Main {
    public static void main(String[] args) {
        System.out.println(\"Hello Git!\");
        // Bug fixed
    }
}" > main.java

# 4. Add and commit changes
git add main.java
git commit -m "Fixed bug in main.java"
```

---

## STEP 7: Merge Both Branches

### Commands:

```bash
# 1. Switch to main branch
git checkout main

# 2. Merge feature-update branch
git merge feature-update

# 3. Merge bug-fix branch
git merge bug-fix

# 4. Check log to see all commits and merges
git log --graph --oneline
```

---

## STEP 8: Resolve Merge Conflicts (If Any)

### If conflicts occur:

```bash
# 1. Open conflicted file and look for conflict markers:
# <<<<<<< HEAD
# content from current branch
# =======
# content from merged branch
# >>>>>>> branch-name

# 2. Edit manually - keep correct code and remove conflict markers

# 3. Add resolved file
git add <filename>

# 4. Commit resolution
git commit -m "Resolved merge conflict in <filename>"
```

---

## FINAL CHECK

### Useful Commands to Verify:

```bash
# Show all commits
git log

# Show branch structure
git branch -a

# Show commit history with graph
git log --graph --oneline --all
```

---

## Summary of Commands Used

| Step | Command | Description |
|------|---------|-------------|
| 1 | `git init` | Initialize Git repository |
| 1 | `git config user.name "..."` | Set username |
| 1 | `git config user.email "..."` | Set email |
| 2 | `git status` | Check repository status |
| 2 | `git add <file>` | Add file to staging |
| 3 | `git commit -m "..."` | Commit staged files |
| 5 | `git checkout -b <branch>` | Create and switch branch |
| 7 | `git merge <branch>` | Merge branch into current |
| 8 | `git add <file>` | Stage resolved file |
| 8 | `git commit` | Commit conflict resolution |

---

## Note
This guide documents the Git workflow steps without executing them or pushing to GitHub, as per the user's instruction "create only file and dont push".

