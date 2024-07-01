import os

def get_sensitive_info():
    # Retrieve sensitive information from environment variables
    return os.environ.get("API_KEY", "No API Key Found")

# Main script
sensitive_info = get_sensitive_info()
print(f"[INFO] Sensitive Information: {sensitive_info}")
