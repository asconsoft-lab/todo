module.exports = {
  ci: {
    collect: {
      numberOfRuns: 3,
      url: ['https://academy.gintaa.com/'],
      startServerCommand: 'rails server -e production',
    },
    upload: {
      target: 'temporary-public-storage',
    },
  },
};


































