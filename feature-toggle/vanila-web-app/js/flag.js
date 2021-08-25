export function checkFeatureFlag(flagName){
    return localStorage.getItem(flagName) == 'true';
}
