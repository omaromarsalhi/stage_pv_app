import axios from 'axios';
import { API_BASE_URL } from '../configs/apiConfig';

export const loadModules = async () => {
    try {
        const response = await axios.get(`${API_BASE_URL}/modules`);
        return response.data;
    } catch (error) {
        console.error('Error loading modules:', error);
        throw error;
    }
};

export const loadGrades = async (moduleId) => {
    try {
        const response = await axios.get(`${API_BASE_URL}/grades`, {
            params: { moduleId }
        });
        return response.data;
    } catch (error) {
        console.error('Error loading grades:', error);
        throw error;
    }
};

export const loadStudents = async (gradeId) => {
    try {
        const response = await axios.get(`${API_BASE_URL}/users`, {
            params: { gradeId }
        });
        return response.data;
    } catch (error) {
        console.error('Error loading students:', error);
        throw error;
    }
};

export const submitMarks = async (marksData) => {
    try {
        const response = await axios.post(`${API_BASE_URL}/marks`, marksData);
        return response.data;
    } catch (error) {
        console.error('Error submitting marks:', error);
        throw error;
    }
};
