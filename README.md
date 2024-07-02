# 📧 Email Library

A robust and flexible email sending library written in Go.

## 🌟 Features

- ✉️ Send plain-text or HTML emails.
- 📎 Attach files to your emails.
- 🔐 Supports SSL and TLS configurations.
- 🛠 Easily extendable with functional options.

## 📥 Installation

Install the library using:

```bash
go get github.com/devzolo/go-mail
```

## 🚀 Usage

### 1. **Initialization**

Setup your SMTP server configuration:

```java
config := mail.EmailConfig{
    Host:     "smtp.example.com",
    Port:     587,
    Username: "your_username",
    Password: "your_password",
    From:     "sender@example.com",
    SSLMode:  false,
}

sender := mail.NewEmailSender(
    mail.WithHost(config.Host),
    mail.WithPort(config.Port),
    mail.WithUsername(config.Username),
    mail.WithPassword(config.Password),
    mail.WithFrom(config.From),
    // Add TLS config or enable SSLMode using additional setters if needed.
)
```

### 2. **Sending an Email**

Craft and send your message:

```go
email := mail.Email{
    To:      []string{"recipient1@example.com", "recipient2@example.com"},
    Subject: "Hello, World!",
    Body:    "This is a plain-text email.",
}

// For HTML emails:
// email.SetHTMLBody("<h1>This is an HTML email.</h1>")

err := sender.Send(email)
if err != nil {
    log.Fatal("❌ Failed to send email:", err)
}
```

### 3. **Attaching Files**

To add attachments:

```go
email := mail.Email{
    To:          []string{"recipient@example.com"},
    Subject:     "Here's your attachment",
    Body:        "Please find the attached file.",
    Attachments: []string{"path/to/your/file.txt"},
}

err := sender.Send(email)
if err != nil {
    log.Fatal("❌ Failed to send email:", err)
}
```

## 📦 Dependencies

- [gomail.v2](https://pkg.go.dev/gopkg.in/gomail.v2)

## ⚠️ Error Handling

Always handle errors. The library checks for emails without recipients:

```go
err := sender.Send(email)
if err != nil {
    if err.Error() == mail.ErrNoRecipients {
        log.Println("⚠️ No recipients specified for the email.")
    } else {
        log.Fatal("❌ Failed to send email:", err)
    }
}
```

## 👥 Contribute

Jump in! 🏊‍♂️ [Open an issue](https://github.com/devzolo/go-mail/issues) or submit PRs.

## 📜 License

[MIT](LICENSE)
