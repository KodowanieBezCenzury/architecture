export function isFeatureEnabled(featureName){
    return localStorage.getItem(featureName) == 'true';
}
