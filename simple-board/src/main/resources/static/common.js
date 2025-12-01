// common.js

const API_BASE = '/api';

function getToken() {
  return localStorage.getItem('accessToken');
}

function setToken(token) {
  localStorage.setItem('accessToken', token);
}

function clearToken() {
  localStorage.removeItem('accessToken');
}

function requireAuth() {
  if (!getToken()) {
    window.location.href = 'login.html';
  }
}

/**
 * 공통 fetch 래퍼
 */
async function apiFetch(path, options = {}) {
  const url = path.startsWith('http') ? path : `${path}`;
  const headers = options.headers ? { ...options.headers } : {};

  const token = getToken();
  if (token) {
    headers['Authorization'] = `Bearer ${token}`;
  }

  // body가 있으면 기본적으로 JSON 전송
  if (options.body && !(options.body instanceof FormData)) {
    headers['Content-Type'] = 'application/json';
  }

  const res = await fetch(url, { ...options, headers });

  if (res.status === 401) {
    clearToken();
    alert('로그인이 필요합니다.');
    window.location.href = 'login.html';
    return Promise.reject(new Error('Unauthorized'));
  }

  return res;
}

function formatDateTime(isoString) {
    if (!isoString) return '';
    const d = new Date(isoString);
    if (Number.isNaN(d.getTime())) return isoString;

    const year = d.getFullYear();
    const month = String(d.getMonth() + 1).padStart(2, '0');
    const day = String(d.getDate()).padStart(2, '0');

    const week = ["일","월","화","수","목","금","토"];
    const dayName = week[d.getDay()];

    const hour = String(d.getHours()).padStart(2, "0");
    const min = String(d.getMinutes()).padStart(2, "0");

    return `${year}-${month}-${day} (${dayName}) ${hour}:${min}`;
}

function logout() {
  clearToken();
  window.location.href = 'login.html';
}
