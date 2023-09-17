let HOST = 'http://localhost:8091';
let API_UPLOAD_PATH = '/api/users/upload';
let API_GET_USERS_PATH = '/api/users';

function apiUploadFile (file) {
    return fetch(HOST + API_UPLOAD_PATH, {method: 'POST', body: file})
}

function apiGetUsers (pageNumber, sortBy, sortDirection, searchQuery) {
    return fetch(
         buildGetUsersUrl(pageNumber, sortBy, sortDirection, searchQuery),
        {method: 'GET'}
    )
}

function buildGetUsersUrl(pageNumber, sortBy, sortDirection, searchQuery) {
    let baseUrl = HOST + API_GET_USERS_PATH + '?pageSize=10&pageNumber=' + pageNumber;
    if (sortBy != null && sortDirection != null) {
        baseUrl = baseUrl + '&sortColumn=' + sortBy + '&sortDirection=' + sortDirection;
    }

    if (searchQuery !== undefined && searchQuery !== null) {
        baseUrl = baseUrl + '&searchQuery=' + searchQuery;
    }
    return baseUrl;
}