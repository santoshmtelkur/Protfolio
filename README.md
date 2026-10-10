# Frame/Flow — Professional Video Editor Portfolio

Production-ready portfolio website with a public client-facing gallery and protected admin dashboard.

## Stack
- Frontend: React + Vite
- Backend: Spring Boot 3.5 + Java 21
- Auth: JWT + Spring Security
- Database: PostgreSQL
- Video storage: Cloudinary
- Deployment: Render Docker + Render PostgreSQL

## Features
- Premium responsive portfolio design
- Public video gallery with category filters
- Full-screen video preview
- Private `/admin` dashboard
- JWT-protected upload/delete APIs
- Multipart video uploads to Cloudinary
- PostgreSQL metadata persistence
- Render Blueprint (`render.yaml`)
- No local video storage, so uploaded work survives Render restarts/deploys

## Deploy on Render
1. Push this folder to a GitHub repository.
2. In Render, create a **Blueprint** from the repository.
3. Render reads `render.yaml` and creates the web service + PostgreSQL database.
4. In the web service environment, set:
   - `ADMIN_EMAIL`
   - `ADMIN_PASSWORD`
   - `CLOUDINARY_CLOUD_NAME`
   - `CLOUDINARY_API_KEY`
   - `CLOUDINARY_API_SECRET`
5. Deploy.
6. Open `https://YOUR-SERVICE.onrender.com/admin` to upload portfolio videos.

### Cloudinary
Create a Cloudinary account and copy the cloud name, API key and API secret into Render environment variables. Videos are uploaded into the `editor-portfolio` folder.

### Local run
Backend:
```bash
cd backend
mvn spring-boot:run
```
Frontend:
```bash
cd frontend
npm install
npm run dev
```
For local development, change `API` in `frontend/src/main.jsx` to `http://localhost:8080/api` or add a Vite proxy.

## Production security notes
- Use a long random `JWT_SECRET` (Render's `generateValue` does this automatically).
- Use a unique strong admin password.
- Never commit Cloudinary credentials.
- Consider adding a custom domain and HTTPS through Render.
- For very large source videos, configure Cloudinary upload limits/transformations appropriate to the editor's workflow.
