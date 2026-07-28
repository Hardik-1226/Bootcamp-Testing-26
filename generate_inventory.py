import os
import urllib.parse
import datetime
import subprocess
import csv

repo_root = r"e:\Bootcamp Testing'26"
os.chdir(repo_root)

# First stage all changes so git ls-files sees the new files and deleted files
subprocess.run(["git", "add", "-A"])

# Get tracked files
result = subprocess.run(["git", "ls-files"], capture_output=True, text=True)
files = result.stdout.splitlines()

base_url = "https://github.com/Hardik-1226/Bootcamp-Testing-26/blob/main/"

with open("file_inventory.csv", "w", newline="", encoding="utf-8") as f:
    writer = csv.writer(f, quoting=csv.QUOTE_ALL)
    writer.writerow(["File Name", "GitHub Link", "Last Modified"])
    
    for file in files:
        # URL encode the file path components for the github link
        url_path = urllib.parse.quote(file)
        github_link = base_url + url_path
        
        # Get last modified time if file exists locally
        if os.path.exists(file):
            mtime = os.path.getmtime(file)
            last_modified = datetime.datetime.fromtimestamp(mtime).strftime("%Y-%m-%d %H:%M:%S")
        else:
            last_modified = "N/A"
            
        writer.writerow([file, github_link, last_modified])

print("file_inventory.csv generated successfully.")
