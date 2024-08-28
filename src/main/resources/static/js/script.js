// Fonction pour initialiser le menu latéral
function initSideMenu() {
    const allSideMenu = document.querySelectorAll('#sidebar .side-menu.top li a');
    allSideMenu.forEach(item => {
        const li = item.parentElement;
        item.addEventListener('click', function () {
            allSideMenu.forEach(i => {
                i.parentElement.classList.remove('active');
            });
            li.classList.add('active');
        });
    });
}

// Fonction pour initialiser le graphique
function initPieChart() {
    const ctx = document.getElementById('myPieChart');
    if (ctx) {
        const myPieChart = new Chart(ctx.getContext('2d'), {
            type: 'pie',
            data: {
                labels: ['Élèves', 'Professeurs'],
                datasets: [{
                    data: [1020, 2834],
                    backgroundColor: ['#ff6384', '#36a2eb'],
                    hoverOffset: 2
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'right',
                    }
                }
            }
        });
    }
}

let deletedId = null;

// Ouvrir le modal
function openModal(id) {
    deletedId = id;
    const modal = document.getElementById("confirmModal");
    if (modal) {
        modal.style.display = "block";
        const form = document.getElementById("deleteForm");
        if (form) {
            form.action = `/teachers/delete/${id}`;
        }
    } else {
        console.error("Modal element not found");
    }
}

// Fermer le modal
function closeModal() {
    const modal = document.getElementById("confirmModal");
    if (modal) {
        modal.style.display = "none";
        deletedId = null;
    } else {
        console.error("Modal element not found");
    }
}

// Fonction de confirmation de suppression
function confirmDelete(event) {
    event.preventDefault();
    const form = document.getElementById("deleteForm");

    if (form && deletedId !== null) {
        form.submit();
    } else {
        console.error("DeleteForm element not found or deletedId is null");
    }
    closeModal();
}

// Initialisation au chargement du DOM
document.addEventListener('DOMContentLoaded', function () {
    initSideMenu();
    initPieChart(); // Cette fonction ne fera rien si l'élément 'myPieChart' n'existe pas

    const form = document.getElementById("deleteForm");
    if (form) {
        form.addEventListener('submit', confirmDelete);
    }


    if (document.getElementById("confirmModal")) {
        window.openModal = openModal;
        window.closeModal = closeModal;
        window.confirmDelete = confirmDelete;
    }
});
