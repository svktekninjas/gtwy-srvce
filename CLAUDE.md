- to memorize 

## Basic Execution

### Git Workflow Steps
1. Create initial repository with README.md
   ```bash
   echo "# gtwy-srvce" >> README.md
   git init
   git add README.md
   git commit -m "first commit in local Gateway service"
   git branch -M main
   git remote add origin https://github.com/svktekninjas/gtwy-srvce.git
   git push -u origin main
   ```

2. Add codebase and push to main
   ```bash
   git add *
   git commit -m "adding base code to the local repository to push to remote"
   git push origin
   ```

3. Create branch structure
   ```bash
   git checkout -b base
   git push -u origin base
   git checkout -b ci_ghwf_gtwysrvce base
   git push -u origin ci_ghwf_gtwysrvce
   ```

4. Create CI workflow
   ```bash
   mkdir -p .github/workflows
   # Create ci.yml file
   git add .github/workflows/ci.yml
   git commit -m "Add initial CI workflow for Java Gateway Service"
   git push origin ci_ghwf_gtwysrvce
   ```

5. Configure documentation and git ignores
   ```bash
   mkdir -p Docs
   # Create .gitignore to exclude Docs directory
   # Update workflow to ignore Docs changes
   git add .github/workflows/ci.yml .gitignore
   git commit -m "Update CI workflow to ignore Docs folder and add .gitignore"
   git push origin ci_ghwf_gtwysrvce
   ```

6. Update workflow to trigger only on main branch
   ```bash
   # Edit ci.yml to trigger only on pushes or PRs to main
   git add .github/workflows/ci.yml
   git commit -m "Update CI workflow to trigger only on pushes or PRs to main branch"
   git push origin ci_ghwf_gtwysrvce
   ```

7. Create Pull Request
   ```bash
   # Create PR from ci_ghwf_gtwysrvce to main branch
   gh pr create --base main --head ci_ghwf_gtwysrvce --title "Basic CI workflow for Java Gateway Service" --body "This PR will only create basic CI workflow with maven build and test."
   # PR created: https://github.com/svktekninjas/gtwy-srvce/pull/1
   ```

8. Add SonarCloud Integration
   ```bash
   # Update pom.xml with JaCoCo and SonarQube plugins
   # Create sonar-project.properties file
   # Fix SonarCloud organization key (svktek instead of svktekninjas)
   # Verify SonarCloud organization and project
   curl -s -u <token>: "https://sonarcloud.io/api/organizations/search?member=true" | jq
   curl -s -u <token>: "https://sonarcloud.io/api/components/search?organization=svktek&qualifiers=TRK&q=gtwy-srvce" | jq
   
   # Merge PR
   gh pr merge 1 --repo svktekninjas/gtwy-srvce --merge
   ```

8. Monitor and validate workflow execution
   ```bash
   # List all workflow runs to check status
   gh run list --repo svktekninjas/gtwy-srvce
   
   # Examine specific workflow run details
   gh run view <run-id> --repo svktekninjas/gtwy-srvce
   
   # View detailed logs for failed workflows
   gh run view <run-id> --log-failed --repo svktekninjas/gtwy-srvce
   
   # Inspect successful job details
   gh run view --job=<job-id> --repo svktekninjas/gtwy-srvce
   ```

9. Workflow validation process
   - The GitHub Actions event log shows all workflow runs with their status
   - For each run, we can see the trigger type (pull_request, push)
   - Examining the detailed logs helps identify specific build failures
   - We can verify successful execution by checking job details
   - Artifacts are automatically uploaded on successful runs
- to memorize 

- plan mode