// Estado da aplicação
let clicks = 0;
let energy = 100;

// Seleção de elementos DOM
const clickCountEl = document.getElementById('clickCount');
const energyValueEl = document.getElementById('energyValue');
const feedbackMessageEl = document.getElementById('feedbackMessage');
const actionBtn = document.getElementById('actionBtn');
const resetBtn = document.getElementById('resetBtn');
const themeToggleBtn = document.getElementById('themeToggle');
const themeIconEl = document.getElementById('themeIcon');

// Ação principal
actionBtn.addEventListener('click', () => {
  if (energy <= 0) {
    feedbackMessageEl.textContent = '⚡ Sem energia! Clique em Reiniciar.';
    return;
  }

  clicks += 1;
  energy = Math.max(0, energy - 10);

  // Atualiza a interface
  clickCountEl.textContent = clicks;
  energyValueEl.textContent = `${energy}%`;

  if (energy === 0) {
    feedbackMessageEl.textContent = '🪫 Energia esgotada!';
  } else {
    feedbackMessageEl.textContent = '🚀 Ação executada com sucesso!';
  }
});

// Reiniciar estado
resetBtn.addEventListener('click', () => {
  clicks = 0;
  energy = 100;

  clickCountEl.textContent = clicks;
  energyValueEl.textContent = `${energy}%`;
  feedbackMessageEl.textContent = '🔄 Painel resetado.';
});

// Alternador de Tema (Dark / Light Mode)
themeToggleBtn.addEventListener('click', () => {
  const currentTheme = document.body.getAttribute('data-theme');
  
  if (currentTheme === 'dark') {
    document.body.removeAttribute('data-theme');
    themeIconEl.textContent = '🌙';
  } else {
    document.body.setAttribute('data-theme', 'dark');
    themeIconEl.textContent = '☀️';
  }
});
